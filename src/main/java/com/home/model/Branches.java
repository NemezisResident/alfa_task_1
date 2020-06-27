package com.home.model;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.io.Serializable;

/**
 * Branches
 */
@Entity
@Table(name = "branches", schema = "public")
@Getter @Setter
public class Branches implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id = null;

  @Column(name = "lat")
  private Double lat = null;

  @Column(name = "lon")
  private Double lon = null;

  @Column(name = "title")
  private String title = null;

  @Column(name = "address")
  private String address = null;
}

