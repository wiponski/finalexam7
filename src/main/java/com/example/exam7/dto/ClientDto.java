package com.example.exam7.dto;

import com.example.exam7.entity.Client;
import lombok.*;

import java.time.format.DateTimeFormatter;

@Data
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClientDto {

    private static final ClientDto NO_CLIENT = builder().name("--bad reference--").build();

    public static ClientDto from(Client client) {
        if (client == null) {
            return NO_CLIENT;
        }

        return builder()
                .id(client.getId())
                .name(client.getName())
                .name(client.getEmail())
                .build();
    }
    private Long id;
    private String name;
    private String email;
}
