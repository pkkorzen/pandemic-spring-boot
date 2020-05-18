package com.pkkor.pandemic.mappers;

import com.pkkor.pandemic.enums.characters.Characters;
import org.springframework.stereotype.Component;

@Component
public class CharacterMapper {

    public Characters convertNameToCharacter(String name) {
        String characterNameUpperCase = name.toUpperCase();
        String characterEnumName = characterNameUpperCase.replaceAll(" ", "_");

        return Characters.valueOf(characterEnumName);
    }

    public String convertCharacterToName(Characters character) {
        String[] characterParts = character.getName().split("_");
        StringBuilder characterNameSB = new StringBuilder();

        for (String characterPart : characterParts) {
            characterNameSB
                    .append(characterPart.charAt(0))
                    .append(characterPart.substring(1).toLowerCase())
                    .append(" ");
        }
        characterNameSB.deleteCharAt(characterNameSB.length() - 1);

        return characterNameSB.toString();
    }
}
