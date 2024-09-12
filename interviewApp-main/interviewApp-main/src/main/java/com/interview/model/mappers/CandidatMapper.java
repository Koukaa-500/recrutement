package com.interview.model.mappers;

import com.interview.model.DTO1.CandidatDto;
import com.interview.model.Entity1.Candidat;
import org.modelmapper.ModelMapper;

public class CandidatMapper {
    private static final ModelMapper modelMapper= new ModelMapper();
    public static CandidatDto convertToDTO(Candidat candidat)
    {
        return modelMapper.map(candidat, CandidatDto.class);
    }

    public static Candidat convertToEntity(CandidatDto candidatDto)
    {
        return modelMapper.map(candidatDto, Candidat.class);
    }
}
