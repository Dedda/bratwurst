package org.dedda.bratwurst.parse;

import org.dedda.bratwurst.lang.BWFunction;
import org.dedda.bratwurst.lang.BWInstruction;
import org.dedda.bratwurst.lang.Program;
import org.dedda.bratwurst.lang.classes.BWClass;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static org.dedda.bratwurst.parse.Patterns.*;

/**
 * Created by dedda on 9/25/15.
 *
 * @author dedda
 */
public class Parser {

    private final File sourceFile;
    private final Predicate<String> isInclude = line -> line.matches(INCLUDE);

    /*
     * Parsers:
     */
    private final InstructionParser instructionParser = new InstructionParser();
    private final BWFunctionParser functionParser = new BWFunctionParser();
    private final BWClassParser classParser = new BWClassParser();
    private final ConditionParser conditionParser = new ConditionParser();
    private final LoopParser loopParser = new LoopParser();

    public Parser(File sourceFile) {
        this.sourceFile = sourceFile;
    }

    public Program parse() {
        List<String> lines;
        try {
            lines = Arrays.asList(getFileContents(sourceFile).split("\n"));
        } catch (final IOException e) {
            throw new RuntimeException("can't load source file!", e);
        }
        lines = lines.stream().map(String::trim).collect(Collectors.toList());
        while (hasIncludes(lines)) {
            for (int i = 0; i < lines.size(); i++) {
                if (isInclude.test(lines.get(i))) {
                    try {
                        final String[] included = getFileContents(new File(sourceFile.getParent() + '/' + lines.get(i).substring(1, lines.get(i).length() - 1))).split("\n");
                        lines.remove(i);
                        lines.addAll(i, Arrays.asList(included));
                        break;
                    } catch (final IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        lines = removeComments(lines);
        lines = removeEmptyLines(lines);
        expectBeginLine(lines);
        removeUnnecessaryBegins(lines);
        final List<BWInstruction> instructions = new LinkedList<>();
        final List<BWFunction> functions = new LinkedList<>();
        final List<BWClass> classes = new LinkedList<>();
        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);
            BWInstruction instruction = instructionParser.parse(line, i);
            if (instruction == null) {
                if (line.matches(CLASS_BEGIN)) {
                    int end = classParser.getEnd(lines, i);
                    classes.add(classParser.parse(lines, i));
                    i = end;
                    continue;
                }
                if (line.matches(FUNCTION_BEGIN)) {
                    int end = functionParser.getEndOfFunction(lines, i);
                    functions.add(functionParser.parse(lines, i));
                    i = end;
                    continue;
                }
                if (line.matches(CONDITION_HEAD)) {
                    int end = conditionParser.findEnd(lines, i);
                    instructions.add(conditionParser.parse(lines, i));
                    i = end;
                    continue;
                }
                if (line.matches(LOOP_HEAD)) {
                    int end = loopParser.getEnd(lines, i);
                    instructions.add(loopParser.parse(lines, i));
                    i = end;
                }
            } else {
                instructions.add(instruction);
            }
        }
        final Program program = new Program();
        program.setInstructions(instructions);
        program.setFunctions(functions);
        program.setClasses(classes);
        return program;
    }

    private List<String> removeEmptyLines(final List<String> lines) {
        return lines.stream()
                .filter(line -> !line.trim().isEmpty())
                .collect(Collectors.toList());
    }

    private List<String> removeComments(final List<String> lines) {
        return lines.stream()
                .filter(line -> !line.trim().matches(COMMENT))
                .collect(Collectors.toList());
    }

    private void removeUnnecessaryBegins(final List<String> lines) {
        int counter = 1;
        while (counter < lines.size()) {
            if (lines.get(counter).matches(BEGIN)) {
                lines.remove(counter);
            }
            counter++;
        }
    }

    private void expectBeginLine(List<String> lines) {
        if (!lines.get(0).matches(BEGIN)) {
            throw new RuntimeException("HELP! FIRST INSTRUCTION IS NOT AN ENTRY POINT! WHAT DO?!");
        }
    }

    private String getFileContents(final File file) throws IOException {
        final long size = file.length();
        final char[] buffer = new char[(int) size];
        new FileReader(file).read(buffer);
        return new String(buffer);
    }

    private boolean hasIncludes(final List<String> lines) {
        return lines.stream().anyMatch(isInclude);
    }

    public InstructionParser getInstructionParser() {
        return instructionParser;
    }
}
