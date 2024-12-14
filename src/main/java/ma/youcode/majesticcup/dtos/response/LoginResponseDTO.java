package ma.youcode.majesticcup.dtos.response;

public record LoginResponseDTO(
        String token,
        long expiredIn
) {
}
