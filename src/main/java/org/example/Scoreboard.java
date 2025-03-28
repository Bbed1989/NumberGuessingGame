package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Scoreboard {
    private static final String FILE_NAME = "score_board.json";
    private static final String EMPTY_JSON = "[]";

    void updateHighScore(int level, int attempts) throws IOException {
        List<Map<String, Object>> scores = readScores();
        if (scores.isEmpty()) {
            addScore(scores, level, attempts);
        } else {
            changeScore(scores, level, attempts);
        }
    };

    void showHighScores(){

    };

    private void addScore(List<Map<String, Object>> scores, int level, int attempts) throws IOException {
        Map<String, Object> newScore = new HashMap<>();
        newScore.put("level", level);
        newScore.put("attempts", attempts);
        scores.add(newScore);
        write(scores);
    }

    private void changeScore(List<Map<String, Object>> scores, int level, int attempts) throws IOException {
        Map<String, Object> newScore = new HashMap<>();
        for (Map<String, Object> scoreMap : scores) {
            if (Integer.parseInt(scoreMap.get("level").toString()) == level) {
                newScore.put("attempts", attempts);
                scores.add(newScore);
                write(scores);
            }
        }
    }

    private List<Map<String, Object>> readScores() throws IOException {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            return new ArrayList<>();
        }
        String jsonString = readFileContent(file).trim();

        if (jsonString.isEmpty() || jsonString.equals(EMPTY_JSON)) {
            return new ArrayList<>();
        }
        return parseFromJson(jsonString);
    }

    // Helper method to read the content of a file
    private String readFileContent(File file) throws IOException {
        StringBuilder json = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                json.append(line);
            }
        }
        return json.toString();
    }

    private List<Map<String, Object>> parseFromJson(String jsonString) {
        List<Map<String, Object>> list = new ArrayList<>();
        String[] objects = jsonString.substring(1, jsonString.length() - 1).split("},\\{");
        for (String obj : objects) {
            obj = obj.trim();
            if (!obj.startsWith("{")) obj = "{" + obj;
            if (!obj.endsWith("}")) obj = obj + "}";
            list.add(parseJsonToMap(obj));
        }
        return list;
    }

    private Map<String, Object> parseJsonToMap(String json) {
        Map<String, Object> map = new HashMap<>();
        String[] pairs = json.substring(1, json.length() - 1).split(",");
        for (String pair : pairs) {
            String[] keyValue = pair.split(":", 2);
            String key = keyValue[0].trim().replaceAll("\"", "");
            String value = keyValue[1].trim().replaceAll("\"", "");
            map.put(key, value);
        }
        return map;
    }

    private void write(List<Map<String, Object>> expenses) throws IOException {
        try (FileWriter writer = new FileWriter(FILE_NAME)) {
            // filter empty maps
            List<Map<String, Object>> nonEmptyExpenses = expenses.stream()
                    .filter(expense -> !expense.isEmpty())  //skip empty
                    .toList();

            if (nonEmptyExpenses.isEmpty()) {
                writer.write("[]");
            } else {
                writer.write("[\n");
                String jsonContent = nonEmptyExpenses.stream()
                        .map(this::mapToJson)
                        .collect(Collectors.joining(",\n"));
                writer.write(jsonContent);
                writer.write("\n]");
            }
        }
    }

    private String mapToJson(Map<String, Object> map) {
        StringBuilder json = new StringBuilder("{");
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            json.append("\"").append(entry.getKey()).append("\":");
            json.append("\"").append(entry.getValue()).append("\",");
        }
        if (json.length() > 1) {
            json.deleteCharAt(json.length() - 1); // Видалення останньої коми
        }
        json.append("}");
        return json.toString();
    }
}
