package com.devops.calculadoraAPI.controlador;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.net.InetAddress;

@RestController
@RequestMapping("/")
public class InfoController {
	@RequestMapping(value = "/ip", method = RequestMethod.GET)
	public ResponseEntity<String> ip() {
		try {
			InetAddress address = InetAddress.getLocalHost();
			return ResponseEntity.status(200).body(
					"<html><body><title>" + address.getHostAddress()
							+ "</title> <h1>" + address.getHostAddress()
							+ "</h1><br/> <h2>" + address.getHostName()
							+ "</h2></body></html> ");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(500).body(
					"Error al intentar obtener la direccion ip");
		}
	}
}