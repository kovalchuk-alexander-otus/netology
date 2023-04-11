package ru.maki;

import java.util.List;
import java.util.stream.Collectors;

public class Filter {
    public List<Integer> filterOut(List<Integer> list, int thresholdValue) {
        Logger logger = Logger.get();
        logger.log("Запускаем фильтрацию");
        return list
                .stream()
                // .filter(v -> v > thresholdValue)
                .filter(v -> {
                    if (v > thresholdValue) {
                        logger.log(new StringBuilder()
                                .append("Элемент \"")
                                .append(v)
                                .append("\" проходит")
                                .toString());
                        return true;
                    }
                    logger.log(new StringBuilder()
                            .append("Элемент \"")
                            .append(v)
                            .append("\" не проходит")
                            .toString());
                    return false;
                })
                .collect(Collectors.toList());
    }
}
