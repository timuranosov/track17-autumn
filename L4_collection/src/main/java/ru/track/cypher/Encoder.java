package ru.track.cypher;

import java.util.Map;

import org.jetbrains.annotations.NotNull;

/**
 * Класс умеет кодировать сообщение используя шифр
 */
public class Encoder {

    /**
     * Метод шифрует символы текста в соответствие с таблицей
     * NOTE: Текст преводится в lower case!
     *
     * Если таблица: {a -> x, b -> y}
     * то текст aB -> xy, AB -> xy, ab -> xy
     *
     * @param cypherTable - таблица подстановки
     * @param text - исходный текст
     * @return зашифрованный текст
     */
    public String encode(@NotNull Map<Character, Character> cypherTable, @NotNull String text) {
        text = text.toLowerCase();
        StringBuilder sb = new StringBuilder();
        //получим все ключи из мапы
        for (char key : cypherTable.keySet()) {
            sb.append(key);
        }
        //составим строку из ключей
        String usedChars = sb.toString();
        //обнуляем StringBuilder
        sb = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            //если встретили символ, равный ключу мапы, то записываем его зашифрованным
            if (usedChars.indexOf(c) >= 0) {
                sb.append(cypherTable.get(c));
            } else {
                //иначе просто записываем не содержащийся в ключах мапы символ
                sb.append(c);
            }
        }
        return sb.toString();
    }
}