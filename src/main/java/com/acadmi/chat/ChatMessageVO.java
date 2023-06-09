package com.acadmi.chat;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

import com.acadmi.member.MemberFilesVO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ChatMessageVO {
	
	private Long msgNum;
	private String msgSender;
	private String msgRecipient;
	private String msgContents;
	private LocalDateTime msgDate;
	private Integer msgStatus;
	private Long chatNum;
	private ChatFilesVO chatFilesVO;
	private MemberFilesVO memberFilesVO;

}
