package com.interview.model.mappers;

import com.interview.model.DTOBachka.CandidatDto;
import com.interview.model.DTOBachka.CandidatureDto;
import com.interview.model.EntityBachka.Candidat;
import com.interview.model.EntityBachka.Candidature;
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
