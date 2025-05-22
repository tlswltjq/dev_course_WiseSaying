package com.back.wiseSaying;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class WiseSayingRepository {
    private final String dbPath = "/Users/jiseopshin/DEV/dev_course_WiseSaying/src/main/resources";

    public WiseSaying save(WiseSaying wiseSaying) {
        Path filePath = Paths.get(dbPath, wiseSaying.getId() + ".json");
        try {
            Files.createDirectories(filePath.getParent());
            Files.writeString(filePath, wiseSaying.toJson());
            return wiseSaying;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public WiseSaying findById(Integer id) {
        try {
            String content = Files.readString(Paths.get(dbPath, id + ".json"));
            return WiseSaying.fromJson(content);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public List<WiseSaying> findAll() {
        try (Stream<Path> stream = Files.list(Paths.get(dbPath))) {
            return stream
                    .filter(file -> file.toString().endsWith(".json"))
                    .map(file -> {
                        try {
                            String jsonContent = Files.readString(file);
                            return WiseSaying.fromJson(jsonContent);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    })
                    .toList();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public WiseSaying update(WiseSaying wiseSaying) {
        return save(wiseSaying);
    }

    public String delete(WiseSaying wiseSaying) {
        try {
            Files.deleteIfExists(Paths.get(dbPath, wiseSaying.getId() + ".json"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return wiseSaying.getId() + "번 명언 삭제";
    }

    public String deleteById(Integer id) {
        WiseSaying wiseSaying = findById(id);
        return delete(wiseSaying);
    }

    public String deleteAll() {
        findAll().forEach(this::delete);
        return "모두 삭제";
    }
}
