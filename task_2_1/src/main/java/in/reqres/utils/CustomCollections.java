package in.reqres.utils;

import in.reqres.dto.UserDataResourceResponse;
import in.reqres.dto.UserDataResponse;
import org.apache.commons.io.FilenameUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomCollections {
    public static List<Integer> saveYears(List<UserDataResourceResponse> years) {
        List<Integer> list = new ArrayList<>();
        years.forEach(x -> list.add(x.getYear()));
        return list;
    }

    public static List<Integer> saveSortedYears(List<UserDataResourceResponse> years) {
        List<Integer> list = new ArrayList<>();
        years.forEach(x -> list.add(x.getYear()));
        Collections.sort(list);
        return list;
    }

    /**
     * getBaseName() - получает имя файла без формата файла с помощью substring()
     *
     * @param avatars список URL
     * @return список имен файлов
     */
    public static List<String> getOnlyAvatarNames(List<UserDataResponse> avatars) {
        List<String> avatarNames = new ArrayList<>();
        avatars.forEach(x -> avatarNames.add(FilenameUtils.getBaseName(x.getAvatar())));
        return avatarNames;
    }

}
