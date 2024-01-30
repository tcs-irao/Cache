package com.Cache.Cachedemo.Bean;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

@Data
@Getter
@Setter
@Entity
@ToString
@Table(name="State")
@org.hibernate.annotations.Cache(usage= CacheConcurrencyStrategy.READ_WRITE)
public class State {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name="id")
    private Long Id;

    @Column(name="State_Name")
    private String StateName;

    @Column(name="zone")
    private String zone;

}
