package org.testaccenture.franchise.utils;

import static org.testaccenture.franchise.utils.SystemConstants.BRANCH_NAME_LENGTH;
import static org.testaccenture.franchise.utils.SystemConstants.FRANCHISE_NAME_LENGTH;
import static org.testaccenture.franchise.utils.SystemConstants.PRODUCT_NAME_LENGTH;

public class Constants {

	// ERRORS
	public static final String HTTP_MESSAGE1 = "Problema de método HTTP, se esperaba la petición por medio del método ";
	public static final String HTTP_MESSAGE2 = " pero se solicitó por medio del metodo ";
	
	public static final String ID_NOT_NULL = "El id no puede ser nulo.";
	public static final String ID_VALUE_MINIMUM = "El ID ingresado debe ser mayor o igual a 1";
	public static final String NO_CONTENT = "No hay registros";
	public static final String NO_CONTENT_ID = "No hay registros con el id = ";
	public static final String YES_CONTENT = "Si hay registros";

	// BRANCH
	public static final String FRANCHISE_BRANCH_NOT_EXISTS = "La franquisia no existe en la tabla Frachise.";
	public static final String BRANCH_NAME_EXISTS = "El nombre de la sucursal ya existe en la franquicia asociada.";
	public static final String BRANCH_NAME_NOT_BLANK = "El nombre de la sucursal no puede ser vacío.";
	public static final String BRANCH_NAME_NOT_NULL = "El nombre de la sucursal no puede ser nulo.";
	public static final String BRANCH_NAME_SIZE = "El tamaño del nombre de la sucursal es mínimo de 1 y máximo de " + BRANCH_NAME_LENGTH + ".";
	public static final String SUCCESSFULLY_CREATED_BRANCH = "Sucursal creada exitosamente.";
	public static final String SUCCESSFULLY_UPDATED_BRANCH = "Sucursal actualizada exitosamente.";

	// FRANCHISE
	public static final String FRANCHISE_NAME_EXISTS = "El nombre de la franquicia ya existe.";
	public static final String FRANCHISE_NAME_NOT_BLANK = "El nombre de la franquicia no puede ser vacío.";
	public static final String FRANCHISE_NAME_NOT_NULL = "El nombre de la franquicia no puede ser nulo.";
	public static final String FRANCHISE_NAME_SIZE = "El tamaño del nombre de la franquicia es mínimo de 1 y máximo de " + FRANCHISE_NAME_LENGTH + ".";
	public static final String SUCCESSFULLY_CREATED_FRANCHISE = "Franquicia creada exitosamente.";
	public static final String SUCCESSFULLY_UPDATED_FRANCHISE = "Franquicia actualizada exitosamente.";

	// PRODUCT
	public static final String BRANCH_PRODUCT_NOT_EXISTS = "La sucursal no existe en la tabla Branch.";
	public static final String PRODUCT_NAME_EXISTS = "El nombre del producto ya existe en la sucursal asociada.";
	public static final String PRODUCT_NAME_NOT_BLANK = "El nombre del producto no puede ser vacío.";
	public static final String PRODUCT_NAME_NOT_NULL = "El nombre del producto no puede ser nulo.";
	public static final String PRODUCT_NAME_SIZE = "El tamaño del nombre del producto es mínimo de 1 y máximo de " + PRODUCT_NAME_LENGTH + ".";
	public static final String PRODUCT_STOCK_MINIMUM = "El stock del producto ingresado debe ser mayor o igual a 0";
	public static final String PRODUCT_STOCK_NOT_NULL = "El stock del producto no puede ser nulo.";
	public static final String SUCCESSFULLY_CREATED_PRODUCT = "Producto creado exitosamente.";
	public static final String SUCCESSFULLY_DELETED_PRODUCT = "Producto eliminado exitosamente.";
	public static final String SUCCESSFULLY_UPDATED_PRODUCT = "Producto actualizado exitosamente.";
}