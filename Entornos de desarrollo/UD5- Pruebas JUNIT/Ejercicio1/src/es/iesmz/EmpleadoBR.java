package es.iesmz;

public class EmpleadoBR {
    static float calculaSalarioBruto(TipoEmpleado tipus, float ventasMes, float horasExtra){
        if (tipus == null || ventasMes < 0 || horasExtra < 0) return -1;
        float salario = 0;
        switch (tipus){
            case venedor -> salario = 1000;
            case encarregat -> salario = 1500;
        }
        if (ventasMes >= 1500) salario += 200;
        else if (ventasMes >= 1000) salario += 100;

        for (int i = 0; i < horasExtra; i++) {
            salario += 20;
        }
        return salario;
    }

    static float calculaSalarioNeto(float salarioBruto) {
        float retencion = 0.0f;

        if (salarioBruto >= 1000 && salarioBruto < 1500) retencion = 16;
        if (salarioBruto >= 1500) retencion = 18;
        if (0 > salarioBruto) return -1;

        return salarioBruto * (1-(retencion/100));
    }
}
