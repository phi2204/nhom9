package com.nhom9.donorweb.model;

import java.util.Collection;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "topic")
public class Topic {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne
	@JoinColumn(name = "id_org")
	private ToChuc tochuc;
	private String ten_topic;
	private String mo_ta;
	private String noi_dung;
	private Integer so_tien;
	private Integer money_donor;
	private String img;
	@OneToMany(mappedBy = "topic", fetch = FetchType.EAGER)
	private Collection<Donations> donations;
	@Override
	public String toString() {
		return "Topic [id=" + id + ", ten_topic=" + ten_topic + ", mo_ta=" + mo_ta
				+ ", noi_dung=" + noi_dung + ", so_tien=" + so_tien + ", money_donor=" + money_donor + ", img=" + img
				+ "]";
	}
	
	
}
