package com.devsuperior.dslist2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dslist2.dto.GameListDTO;
import com.devsuperior.dslist2.entities.GameList;
import com.devsuperior.dslist2.repositories.GameListRepository;

@Component
public class GameListService {
	@Autowired
	private GameListRepository gameListRepository;

	@Transactional(readOnly = true)
	public List<GameListDTO> findAll() {
		List<GameList> result = gameListRepository.findAll();
		List<GameListDTO> gameMinDTOs = result.stream().map(x -> new GameListDTO(x)).toList();
		return gameMinDTOs;

	}
}
