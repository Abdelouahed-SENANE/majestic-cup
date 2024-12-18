package ma.youcode.majesticcup.utils.converter;

import ma.youcode.majesticcup.entities.Role;
import ma.youcode.majesticcup.utils.enums.RoleName;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;

@ReadingConverter
public class StringToRoleConverter implements Converter<String, Role> {

    @Override
    public Role convert(String source) {
        try {
            RoleName roleName = RoleName.valueOf(source);
            return new Role(null , roleName);
        }catch (IllegalArgumentException e){
            return null;
        }
    }
}
