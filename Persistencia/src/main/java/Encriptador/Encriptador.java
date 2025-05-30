/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Encriptador;

import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 **
 * Clase utilitaria para encriptar y desencriptar textos usando AES. AES
 * (Advanced Encryption Standard) es un algoritmo de cifrado simétrico.
 *
 * @author joelr
 */
public class Encriptador {

    // Nombre del algoritmo de cifrado que se usará.
    private static final String ALGORITMO = "AES";
    /**
     * Clave secreta usada para el cifrado y descifrado. Debe tener exactamente
     * 16 caracteres para AES-128 (16 bytes = 128 bits).
     */
    private static final String CLAVE_SECRETA = "1234567890123456"; // 16 caracteres = 128 bits
                                                 

    /**
     * Método que encripta un texto plano usando AES y lo devuelve como una
     * cadena Base64.
     *
     * @param texto El texto original a encriptar.
     * @return El texto encriptado y codificado en Base64.
     * @throws Exception si ocurre un error durante el cifrado.
     */
    public static String encriptar(String texto) throws Exception {
        // Se crea la clave secreta en el formato requerido por AES (16 bytes)
        SecretKeySpec key = new SecretKeySpec(CLAVE_SECRETA.getBytes(), ALGORITMO);
        // Se obtiene una instancia del cifrador AES.
        Cipher cipher = Cipher.getInstance(ALGORITMO);
        // Se inicializa el cifrador en modo ENCRYPT_MODE con la clave.
        cipher.init(Cipher.ENCRYPT_MODE, key);
        // Se cifra el texto y se obtiene el resultado como arreglo de bytes
        byte[] textoEncriptado = cipher.doFinal(texto.getBytes("UTF-8"));
        // Se codifica el resultado en Base64 para facilitar su almacenamiento o transmisión
        return Base64.getEncoder().encodeToString(textoEncriptado);
    }

    /**
     * Método que desencripta un texto encriptado (en Base64) usando AES.
     *
     * @param textoEncriptado El texto encriptado en Base64.
     * @return El texto original desencriptado.
     * @throws Exception si ocurre un error durante el descifrado.
     */
    public static String desencriptar(String textoEncriptado) throws Exception {
        // Se crea la misma clave secreta utilizada para el cifrado.
        SecretKeySpec key = new SecretKeySpec(CLAVE_SECRETA.getBytes(), ALGORITMO);
        // Se obtiene una instancia del cifrador AES.
        Cipher cipher = Cipher.getInstance(ALGORITMO);
        // Se inicializa el cifrador en modo DECRYPT_MODE con la clave.
        cipher.init(Cipher.DECRYPT_MODE, key);
        // Se decodifica el texto encriptado desde Base64 a bytes.
        byte[] bytesDesencriptados = cipher.doFinal(Base64.getDecoder().decode(textoEncriptado));
        // Se convierte el resultado de bytes a una cadena UTF-8 y se devuelve
        return new String(bytesDesencriptados, "UTF-8");
    }
}
