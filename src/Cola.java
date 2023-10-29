import javax.swing.*;
import java.util.LinkedList;
import java.util.Queue;

public class Cola {
    Queue<Dispositivos> dispositivos;
    public Cola(){
        dispositivos= new LinkedList<>();
            }
    public void valoresPredefinidos(){
        dispositivos.add(new Dispositivos("A031", "TPLINK", 2021, 30, "Router"));
        dispositivos.add(new Dispositivos("A032", "SAMSUNG", 2022, 25, "Switch"));
        dispositivos.add(new Dispositivos("A033", "HUAWEI", 2023, 40, "Accesspoint"));
        dispositivos.add(new Dispositivos("A034", "MOVISTAR", 2024, 50, "Router"));
        dispositivos.add(new Dispositivos("A035", "XIAOMI", 2025, 35, "Switch"));
    }
    public void encolarDispositivos(Dispositivos dispostivo) throws Exception{
        for (Dispositivos dispositivos1 : dispositivos) {
            if (dispostivo.getCodigo().equals(dispositivos1.getCodigo())){
                throw new Exception("El dispositivo ya esta en cola");
            }
        }
        dispositivos.add(dispostivo);
    }
    public void desencolarDispositivos(String codigo, int cantidad) throws Exception{
        Dispositivos dispositivoSeleccionado = null;

        for (Dispositivos dispositivo1 : dispositivos) {
            if (dispositivo1.getCodigo().equals(codigo)) {
                dispositivoSeleccionado = dispositivo1;
                break;
            }
        }
        if (dispositivoSeleccionado == null) {
            throw new Exception("El dispositivo no está en cola");
        }
        if (cantidad < 0) {
            throw new Exception("Ingrese una cantidad valida");
        }
        if (cantidad > dispositivoSeleccionado.getCantidad()) {
            throw new Exception("No hay suficientes dispositivos para: " + dispositivoSeleccionado.getCodigo());
        }
        dispositivoSeleccionado.setCantidad(dispositivoSeleccionado.getCantidad() - cantidad);
        if (dispositivoSeleccionado.getCantidad() <= 0) {
            dispositivos.remove(dispositivoSeleccionado);
        }
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        dispositivos.forEach(dispositivo -> sb.append(dispositivo.toString()).append("\n"));
        return sb.toString();
    }
}
