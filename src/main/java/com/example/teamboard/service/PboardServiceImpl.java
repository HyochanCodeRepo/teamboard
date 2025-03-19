package com.example.teamboard.service;

import com.example.teamboard.dto.PboardDTO;
import com.example.teamboard.entity.Member;
import com.example.teamboard.entity.Pboard;
import com.example.teamboard.repository.MemberRepository;
import com.example.teamboard.repository.PboardRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.Email;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.Optional;

@Service
@Log4j2
@RequiredArgsConstructor
@Transactional
public class PboardServiceImpl implements PboardService{

    private final PboardRepository pboardRepository;
    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public void register(PboardDTO pboardDTO, Email email) {
        log.info("이메일 : {} ", email);
        MemberRepository memberRepository = new mem

        Pboard pboard = modelMapper.map(pboardDTO, Pboard.class);
        pboard.setMember(pboardRepository.findByMember_Email());

        pboardRepository.save(pboard);
    }

    @Override
    public Page<PboardDTO> pboardList(String email, Pageable pageable) {

        Page<Pboard> pageList = pboardRepository.findByMember_Email(email, pageable);
        Page<PboardDTO> pageDTOList = pageList.map(sss -> modelMapper.map(sss, PboardDTO.class));
        return pageDTOList;

        // 조회 후 돌려받는 값을 dto로 변환하여 반환한다.
        }

    @Override
    public PboardDTO read(Long pboardNum) {

        Optional<Pboard> optionalPboard =
                pboardRepository.findById(pboardNum);

        Pboard pboard = optionalPboard.get();

        PboardDTO pboardDTO =
                modelMapper.map(pboard, PboardDTO.class);

        return pboardDTO;
    }

    @Override
    public PboardDTO update(PboardDTO pboardDTO) {
        Optional<Pboard> optionalPboard = pboardRepository.findById(pboardDTO.getPboardNum());

        Pboard pboard = optionalPboard.get();

        pboard.setPboardTitle(pboardDTO.getPboardTitle());
        pboard.setPboardContent(pboardDTO.getPboardContent());
        pboardDTO = modelMapper.map(pboard, PboardDTO.class);

        return pboardDTO;
    }

    @Override
    public Long del(Long pboardNum) {

        pboardRepository.deleteById(pboardNum);

        return pboardNum;
    }
}
