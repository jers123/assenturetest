	package org.testaccenture.franchise.utils;

import org.testaccenture.franchise.utils.response.ReplyMessageList;
import org.testaccenture.franchise.utils.response.ReplyMessageSimple;
import org.springframework.http.ResponseEntity;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

public class SystemConstants {

	// PATHS
	public static final String LOCAL_ORIGIN_PATH = "http://localhost:8080";
	public static final String PUBLIC_ORIGIN_PATH = "http://192.168.1.9:8080";
	public static final String LOCAL_ORIGIN_PATH2 = "http://localhost:8081";
	public static final String PUBLIC_ORIGIN_PATH2 = "http://192.168.1.9:8081";
	public static final String API_PATH = "/franchise";
	public static final String CREATE_PATH = "/create";
	public static final String DELETE_PATH = "/delete/";
	public static final String GET_ALL_PATH = "/get-all";
	public static final String GET_ID_PATH = "/get-id/";
	public static final String UPDATE_PATH = "/update";

	// HEADERS
	public static final String ACCEPT = "Accept";
	public static final String CONTENT_TYPE = "Content-Type";
	public static final String LOCATION = "Location";

	// SUBPATHS
	public static final String BRANCH_PATH = "/branch";
	public static final String FRANCHISE_PATH = "/franchise";
	public static final String PRODUCT_PATH = "/product";

	// DATABASE
	public static final String DATABASE = "franchiseDB";
	public static final String SCHEMA = "public";

	//FIELDS
	public static final String ID = "id";
	public static final String NAME = "name";
	
	// BRANCH
	public static final int BRANCH_NAME_LENGTH = 100;
	public static final String FRANCHISE = "franchise";
	public static final String BRANCH_NAME_QUERY = "SELECT b.branchName FROM Branch b WHERE LOWER(b.branchName) = LOWER(:" + NAME + ") AND b.idFranchise.idFranchise = :" + FRANCHISE + " AND b.idBranch != :" + ID;
	public static final String BRANCH_FRANCHISE_QUERY = "SELECT b FROM Branch b WHERE b.idFranchise.idFranchise = :" + ID + " ORDER BY b.branchName ASC";
	public static final String BRANCH_ALL_QUERY = "SELECT b FROM Branch b ORDER BY b.idFranchise.idFranchise, b.branchName ASC";
	public static final String BRANCH_TABLE = "branch";

	// FRANCHISE
	public static final int FRANCHISE_NAME_LENGTH = 50;
	public static final String FRANCHISE_NAME_QUERY = "SELECT f.franchiseName FROM Franchise f WHERE LOWER(f.franchiseName) = LOWER(:" + NAME + ") AND f.idFranchise != :" + ID;
	public static final String FRANCHISE_ALL_QUERY = "SELECT f FROM Franchise f ORDER BY f.franchiseName ASC";
	public static final String FRANCHISE_TABLE = "franchise";

	// PRODUCT
	public static final int PRODUCT_NAME_LENGTH = 20;
	public static final String BRANCH = "branch";
	public static final String STOCK = "stock";
	public static final String PRODUCT_NAME_QUERY = "SELECT p.productName FROM Product p WHERE LOWER(p.productName) = LOWER(:" + NAME + ") AND p.idBranch.idBranch = :" + BRANCH + " AND p.idProduct != :" + ID;
	public static final String PRODUCT_BRANCH_QUERY = "SELECT p FROM Product p WHERE p.idBranch.idBranch = :" + ID + " ORDER BY p.productName ASC";
	public static final String PRODUCT_ALL_QUERY = "SELECT p FROM Product p ORDER BY p.idBranch.idBranch, p.productName ASC";
	public static final String PRODUCT_TABLE = "product";

	public static ResponseEntity<ReplyMessageSimple> answerSimple(ReplyMessageSimple replyMessage) {
		return ResponseEntity
				.status(replyMessage.getHttpStatus())
				.header(LOCATION, replyMessage.getUri())
				.header(ACCEPT, APPLICATION_JSON_VALUE)
				.body(replyMessage);
	}

	public static ResponseEntity<ReplyMessageList> answerList(ReplyMessageList replyMessage) {
		return ResponseEntity
				.status(replyMessage.getHttpStatus())
				.header(LOCATION, replyMessage.getUri())
				.header(ACCEPT, APPLICATION_JSON_VALUE)
				.body(replyMessage);
	}
}