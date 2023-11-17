package com.devsuperior.dslist2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dslist2.dto.GameDTO;
import com.devsuperior.dslist2.dto.GameMinDTO;
import com.devsuperior.dslist2.entities.Game;
import com.devsuperior.dslist2.repositories.GameRepository;

@Component
public class GameService {
	@Autowired
	private GameRepository gameRepository;

	@Transactional(readOnly = true)
	public GameDTO findById(Long gameId) {
		Game result = gameRepository.findById(gameId).get();
		GameDTO gameDTO = new GameDTO(result);
		return gameDTO;
	}

	@Transactional(readOnly = true)
	public List<GameMinDTO> findAll() {
		List<Game> result = gameRepository.findAll();
		List<GameMinDTO> gameMinDTOs = result.stream().map(x -> new GameMinDTO(x)).toList();
		return gameMinDTOs;

	}
}
