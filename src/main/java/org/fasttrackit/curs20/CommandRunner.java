package org.fasttrackit.curs20;

import lombok.RequiredArgsConstructor;
import org.fasttrackit.curs20.model.Room;
import org.fasttrackit.curs20.repository.RoomRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CommandRunner implements CommandLineRunner {
    private final RoomRepository roomRepository;

    @Override
    public void run(String... args){
        roomRepository.saveAll(List.of(
                Room.builder()
                        .build()
        ));
    }
}
