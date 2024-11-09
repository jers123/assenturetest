package org.testaccenture.franchise.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import static org.testaccenture.franchise.utils.SystemConstants.BRANCH_TABLE;
import static org.testaccenture.franchise.utils.SystemConstants.DATABASE;
import static org.testaccenture.franchise.utils.SystemConstants.ID;
import static org.testaccenture.franchise.utils.SystemConstants.NAME;
import static org.testaccenture.franchise.utils.SystemConstants.PRODUCT_NAME_LENGTH;
import static org.testaccenture.franchise.utils.SystemConstants.PRODUCT_TABLE;
import static org.testaccenture.franchise.utils.SystemConstants.SCHEMA;
import static org.testaccenture.franchise.utils.SystemConstants.STOCK;

@Entity
@Table(name = PRODUCT_TABLE, catalog = DATABASE, schema = SCHEMA)
@Getter
@Setter
public class Product extends BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = PRODUCT_TABLE + "_" + ID, nullable = false, updatable = false)
	private Integer idProduct;

	@Column(name=PRODUCT_TABLE + "_" + NAME, nullable=false, length=PRODUCT_NAME_LENGTH)
	private String productName;

	@JoinColumn(name = BRANCH_TABLE + "_" + ID, referencedColumnName = BRANCH_TABLE + "_" + ID, nullable = false,
			foreignKey = @ForeignKey(name = PRODUCT_TABLE + "_" + BRANCH_TABLE + "_fk"))
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private Branch idBranch;
	
	@Column(name=STOCK, nullable=false)
	private Integer stock;
}