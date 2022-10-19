package com.capstone.cappy.service;

import com.capstone.cappy.entities.History;
import com.capstone.cappy.repositories.HistoryRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class HistoryService {
    private final HistoryRepository historyRepository;

    public HistoryService(HistoryRepository historyRepository) {
        this.historyRepository = historyRepository;
    }

    public List<History> getAllForUser(long id) {
        List<History> list = historyRepository.getAllByUser(id);
        System.out.println(list);
        return list;
    }



    @Transactional
    public void saveForUser(long id, History history) {
            historyRepository.save(history);
    }

    public void save(History history) {
//        List<History> historyList = historyRepository.getAllByUser(history.getUser());
//        boolean exists =  historyList
//                .stream()
//                .map(History::getProduct)
//                .anyMatch((id) -> id == history.getProduct());
//
//        if (!exists) {
//            historyRepository.save(history);
//        }
        historyRepository.save(history);
    }

    public List<History> findAll() {
        return historyRepository.findAll();
    }

    public List<History> findAllByUserId(Long userId) {
        return historyRepository.getAllByUserOrderByIdDesc(userId);
//        return historyRepository.getAllByOrderByUser(userId);
    }
}
