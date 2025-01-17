package com.toyproj.pinchhitterhomerun.service;

import com.toyproj.pinchhitterhomerun.entity.ServiceResult;
import com.toyproj.pinchhitterhomerun.exception.MemberException;
import com.toyproj.pinchhitterhomerun.exception.PasswordHintException;
import com.toyproj.pinchhitterhomerun.repository.PasswordHintRepository;
import com.toyproj.pinchhitterhomerun.type.ErrorMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;

@Service
@Transactional
public class PasswordHintService {

    @Autowired
    PasswordHintRepository passwordHintRepository;

    /**
     * 사용 가능한 비밀번호 질문 리스트
     */
    public ServiceResult<Collection<String>> getAllHint() {
        final var hints = passwordHintRepository.findAll();

        if (hints == null) {
            return new ServiceResult<>(ErrorMessage.HINT_DB_ERROR);
        }

        final Collection<String> hintTexts = new ArrayList<>();

        for (var hint : hints) {
            hintTexts.add(hint.getText());
        }

        return new ServiceResult<>(ErrorMessage.SUCCESS, hintTexts);
    }

    /**
     * id로 힌트 텍스트 조회
     */
    public ServiceResult<String> getHintText(Long hintId) {
        final var hint = passwordHintRepository.findById(hintId);

        if (hint == null) {
            return new ServiceResult<>(ErrorMessage.HINT_DB_ERROR);
        }

        return new ServiceResult<>(ErrorMessage.SUCCESS, hint.getText());
    }
}
