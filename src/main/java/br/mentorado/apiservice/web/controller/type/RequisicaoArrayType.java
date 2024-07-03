package br.mentorado.apiservice.web.controller.type;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RequisicaoArrayType {
	private String[][] arrayMultidimensional;
}
