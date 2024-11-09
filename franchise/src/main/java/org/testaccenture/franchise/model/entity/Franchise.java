package org.testaccenture.franchise.model.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

import static org.testaccenture.franchise.utils.SystemConstants.DATABASE;
import static org.testaccenture.franchise.utils.SystemConstants.FRANCHISE_NAME_LENGTH;
import static org.testaccenture.franchise.utils.SystemConstants.FRANCHISE_TABLE;
import static org.testaccenture.franchise.utils.SystemConstants.ID;
import static org.testaccenture.franchise.utils.SystemConstants.NAME;
import static org.testaccenture.franchise.utils.SystemConstants.SCHEMA;

@Entity
@Table(name = FRANCHISE_TABLE, catalog = DATABASE, schema = SCHEMA,
	uniqueConstraints = {
		@UniqueConstraint(name = FRANCHISE_TABLE + "_" + NAME + "_uk", columnNames = {FRANCHISE_TABLE + "_" + NAME}),
	}
)
@Getter
@Setter
public class Franchise extends BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = FRANCHISE_TABLE + "_" + ID, nullable = false, updatable = false)
	private Integer idFranchise;

	@Column(name=FRANCHISE_TABLE + "_" + NAME, nullable=false, length=FRANCHISE_NAME_LENGTH, unique=true)
	private String franchiseName;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idFranchise", fetch = FetchType.LAZY)
	private List<Branch> branchs;
}