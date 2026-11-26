package practice.app.ventas.controller.backoffice;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import practice.app.ventas.model.bd.Usuario;
import practice.app.ventas.model.dto.request.UsuarioRequest;
import practice.app.ventas.model.dto.response.ResultadoResponse;
import practice.app.ventas.service.IUsuarioService;

@AllArgsConstructor
@Controller
@RequestMapping("/seguridad")
public class SeguridadController {

    private IUsuarioService iUsuarioService;

    @GetMapping("/usuario")
    public String frmUsuario(Model model){
        model.addAttribute("listaUsuarios",
                iUsuarioService.listarUsuarios());
        return "backoffice/seguridad/formusuario";
    }
    @GetMapping("/usuario/{id}")
    @ResponseBody
    public Usuario obtenerUsuarioxId(@PathVariable("id") int id){
        return iUsuarioService.obtenerUsuarioxId(id);
    }

    @PostMapping("/usuario/registrar")
    @ResponseBody
    public ResultadoResponse registrarUsuario(@RequestBody UsuarioRequest usuarioRequest){
        String mensaje = "Usuario Registrado correctamente";
        boolean respuesta = true;
        try {
            Usuario usuario = new Usuario();
            if (usuarioRequest.getIdusuario() > 0){
                usuario.setIdusuario(usuarioRequest.getIdusuario());
            }
            else {
                usuario.setPassword(usuarioRequest.getPassword());
                usuario.setNombres(usuarioRequest.getNombres());
                usuario.setApellidos(usuarioRequest.getApellidos());
                usuario.setActivo(usuarioRequest.getActivo());
                iUsuarioService.guardarUsuario(usuario);
            }
        }catch (Exception ex){
            mensaje = "Usuario no registrado, error en la bd";
            respuesta = false;

        }
        return ResultadoResponse.builder().mensaje(mensaje).respuesta(respuesta).build();
    }
}
