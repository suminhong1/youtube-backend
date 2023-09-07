package com.kh.youtube.domain;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Channel {

    private int channelCode;
    private String channelName;
    private String channelPhoto;
    private String channelDesc;
    private Date channelDate;

    @ManyToOne // Channel 엔티티와 Member 엔티티를 다대일 관계로 설정
    @JoinColumn(name="member_id") // 외래키 생성 or Member 엔티티의 기본키와 매핑
    private Member member;



}
