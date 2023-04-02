package com.nhom9.donorweb.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "donations")
public class Donations {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne
	@JoinColumn(name = "id_user")
	private User user;
	@ManyToOne
	@JoinColumn(name = "id_topic")
	private Topic topic;
	private Integer so_tien;
	private String ngay_tao;
	private String tin_nhan;
	private Integer credit_number;
	private String expiration_date;
	private String security_code;
	private String name_card;
}
