package org.testaccenture.franchise.model.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

import static org.testaccenture.franchise.utils.SystemConstants.BRANCH_NAME_LENGTH;
import static org.testaccenture.franchise.utils.SystemConstants.BRANCH_TABLE;
import static org.testaccenture.franchise.utils.SystemConstants.DATABASE;
import static org.testaccenture.franchise.utils.SystemConstants.FRANCHISE;
import static org.testaccenture.franchise.utils.SystemConstants.FRANCHISE_TABLE;
import static org.testaccenture.franchise.utils.SystemConstants.ID;
import static org.testaccenture.franchise.utils.SystemConstants.NAME;
import static org.testaccenture.franchise.utils.SystemConstants.SCHEMA;

@Entity
@Table(name = BRANCH_TABLE, catalog = DATABASE, schema = SCHEMA)
@Getter
@Setter
public class Branch extends BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = BRANCH_TABLE + "_" + ID, nullable = false, updatable = false)
	private Integer idBranch;

	@Column(name=BRANCH_TABLE + "_" + NAME, nullable=false, length=BRANCH_NAME_LENGTH)
	private String branchName;

	@JoinColumn(name = FRANCHISE+ "_" + ID, referencedColumnName = FRANCHISE_TABLE + "_" + ID, nullable = false,
			foreignKey = @ForeignKey(name = BRANCH_TABLE + "_" + FRANCHISE_TABLE + "_fk"))
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private Franchise idFranchise;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idBranch", fetch = FetchType.LAZY)
	private List<Product> products;
}