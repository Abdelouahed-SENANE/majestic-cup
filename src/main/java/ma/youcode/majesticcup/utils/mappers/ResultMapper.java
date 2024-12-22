package ma.youcode.majesticcup.utils.mappers;

import ma.senane.utilities.mappers.GenericMapper;
import ma.youcode.majesticcup.dtos.request.ResultRequestDTO;
import ma.youcode.majesticcup.dtos.response.ResultResponseDTO;
import ma.youcode.majesticcup.entities.Result;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface ResultMapper extends GenericMapper<Result , ResultResponseDTO , ResultRequestDTO> {

}
