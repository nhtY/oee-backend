package com.nht.springdemo.utils;

import com.nht.springdemo.entities.OeePerformance;
import com.nht.springdemo.model.OeePerformanceDTO;
import org.springframework.stereotype.Component;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

@Component
public class OeePerformanceMapperImpl implements OeePerformanceMapper {


    private final DecimalFormat decimalFormat;

    public OeePerformanceMapperImpl() {
        this.decimalFormat = new DecimalFormat("#.##", new DecimalFormatSymbols(Locale.forLanguageTag("tr-TR")));
    }

    @Override
    public OeePerformance dtoToEntity(OeePerformanceDTO oeeDTO) {
        return OeePerformance.builder()
                .ggOee(oeeDTO.getGgOee())
                .gOee1s(oeeDTO.getGOee1s())
                .ttGg(oeeDTO.getTtGg())
                .ttGp(oeeDTO.getTtGp())
                .tt1s(oeeDTO.getTt1s())
                .createdAt(oeeDTO.getCreatedAt())
                .urunGrubu(oeeDTO.getUrunGrubu())
                .redTamir(oeeDTO.getRedTamir())
                .farkliUrun(oeeDTO.getFarkliUrun())
                .build();
    }

    @Override
    public OeePerformanceDTO entityToDto(OeePerformance oeePerformance) {
        return OeePerformanceDTO.builder()
                .id(oeePerformance.getId())
                .gOee1s(Double.valueOf(decimalFormat.format(oeePerformance.getGOee1s())))
                .ggOee(Double.valueOf(decimalFormat.format(oeePerformance.getGgOee())))
                .ttGp(Double.valueOf(decimalFormat.format(oeePerformance.getTtGp())))
                .ttGg(Double.valueOf(decimalFormat.format(oeePerformance.getTtGg())))
                .tt1s(Double.valueOf(decimalFormat.format(oeePerformance.getTt1s())))
                .createdAt(oeePerformance.getCreatedAt())
                .farkliUrun(oeePerformance.getFarkliUrun())
                .redTamir(oeePerformance.getRedTamir())
                .urunGrubu(oeePerformance.getUrunGrubu())
                .build();
    }
}
