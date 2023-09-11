 /*
 This program is free software: you can redistribute it and/or modify
 it under the terms of the GNU General Public License as published by
 the Free Software Foundation, either version 3 of the License, or
 (at your option) any later version.

 This program is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 GNU General Public License for more details.

 You should have received a copy of the GNU General Public License
 along with this program.  If not, see <http://www.gnu.org/licenses/>.

 */
package DataTable;

/**
 * Febrero del 2014
 * @author Máximo Coejo Cores mcoejo@gmail.com
 */
public class util {

    private static final String ciudades[] = {"MADRID", "BARCELONA", "VIGO", "PONTEVEDRA", "ORENSE", "LUGO", "SANTIAGO", "VALENCIA", "ZAMORA", "LEON", "VALLADOLID", "CORUÑA", "SEVILLA", "OVIEDO", "BILBAO", "CADIZ"};
    private static final String cursos[] = {"MATEMATICAS", "JAVA BASICO", "JAVA AVANZADO", "METODOLOGIA DE PROGRAMACION", "BASES DE DATOS", "ENSAMBLADOR", "HOJAS DE CALCULO", "LENGUAJE C", "VB NET", "CISCO SYSTEM", "FOTOGRAFIA", "ELECTRONICA",
        "Montaje y mantenimiento de instalaciones",
        "Montaje E baja tensión",
        "Operaciones telecomunicación en edificios",
        "Montaje solares fotovoltaicas",
        "Montaje y instalaciones térmicas",
        "Inserción laboral,la igualdad de género",
        "Soldadura con electrodo revestido y TIG",
        "Soldador al arco eléctrico (básico)",
        "Montaje de elementos de carpintería",
        "Mantenimiento carrocerías de vehículos",
        "Pintura de vehículos",
        "INGLÉS:ATENCIÓN AL PÚBLICO",
        "INGLÉS: GESTIÓN COMERCIAL",
        "DISEÑO MODIFICACIÓN DE PLANOS 2D Y 3D",
        "DISEÑO PARAMÉTRICO DE PIEZAS",
        "MONTADOR D DISPOSITIVOS Y CUADROS ELECTRÓNICOS",
        "MONTAJE Y MANTO. D INSTALACIONES ELECTR. D B. T.",
        "MONTAJE Y MANTO. D INSTALACIONES ELECTR.",
        "AUTOMATISMO CON CONTROL PROGRAMABLE",
        "ESPECIALISTA EN TOPOGRAFÍA ELECTRÓNICA",
        "ESPECIALISTA EN TOPOGRAFÍA ELECTRÓNICA",
        "SOLDADURA CON ELECTRODO REVESTIDO Y TIG",
        "SOLDADURA CON ELECTRODO REVESTIDO Y TIG",
        "SOLDADURA CON ELECTRODO REVESTIDO Y TIG",
        "SOLDADURA CON ELECTRODO REVESTIDO Y TIG",
        "MECANIZADO POR ARRANQUE DE VIRUTA",
        "SOLDADOR CON MÁQ. SEMIAUTOMÁTIC. MAG MIG",
        "SOLDADOR CON MÁQ. SEMIAUTOMÁTIC. MAG MIG",
        "OPERADOR DE MÁQUINAS HERRAMIENTAS",
        "PREPARADOR PROGRAMADOR DE M. H. CON CNC",
        "AUXILIAR DE LAB.  DE INDUSTRIAS ALIMENTARIAS",
        "AUXILIAR DE LAB.  DE INDUSTRIAS ALIMENTARIAS",
        "ANÁLISIS QUÍMICO",
        "DOCENCIA PARA EL EMPLEO",
        "GESTOR DE FORMACIÓN"};
    private static final String letrasDNI = "TRWAGMYFPDXBNJZSQVHLCKE";
    private static final String nom[] = {"lucia ", "Alvaro ", "Alberto ", "Felipe ", "juan ", "ines ", "manuel ", "raul ", "Alba ", "Montse ", "Adrian ", "Berto ", "Sonia ", "Vicente ", "Sara ", "Luis ", "Marga "};
    private static final String apell[] = {"loma ", "suarez ", "vaca ", "perezoso ", "vela ", "garcia ", "valverde ", "lopez ", "Vilar ", "costa ", "gonzalez ", "piñeiro "};
    private static final String apell2[] = {"gomez ", "sopez ", "valman ", "per ", "vietez ", "norma ", "felipez ", " fernandez ", "solvez "};
    private static final String telf[] = {"986000000 ", "987000000 ", "983000001", "942000001", "975002506"};
    private static final String colores[] = {"AZUL", "ROJO", "AMARILLO", "ROSA", "NEGRO", "VERDE", "MORADO", "BLANCO", "GRIS", "NARANJA", "VIOLETA"};
    private static final String productos[] = {"leche", "Arroz", "Pan", "Pescado", "Lechuga", "Cepillos", "Fiambre", "Sopa", "Espaguetis", "Azucar", "harina"};
    private static final String funciones[] = {"Reparto", "Congelados", "Tecnico", "Comercial", "Otros"};
    private static final String tipos[] = {"Particular", "Empresa", "profesional", "monovolumen", "mini"};

    private static final java.util.Random r = new java.util.Random();

    /**
     * retorna un string con un tipo de vehiculo
     *
     * @return String
     */
    private static String getTipo() {

        return tipos[r.nextInt(tipos.length - 1)];
    }

    /**
     * retorna un Double entre menor de 20 con 2 decimales
     *
     * @return Double
     */
    public static Double getPrecio() {
        String n = String.valueOf(r.nextDouble() * 10);
        n = n.substring(0, n.indexOf('.') + 2);
// verificar 
        return Double.valueOf(n);
    }

    /**
     * retorn un double con 3 decimales
     *
     * @return double
     */
    public static Double getIva() {
        Double a = r.nextDouble();
        String n = a.toString();

        return Double.valueOf(n.substring(0, n.indexOf('.') + 3));
    }

    /**
     * Retorna un String de un productos aleatorio
     *
     * @return String
     */
    public static String getProducto() {
        return productos[r.nextInt(productos.length - 1)];

    }

    /**
     * retorna un Integer comprendido entre 0 y el parametro max
     *
     * @param max integer
     * @return String
     */
    public static int getEdad(int max) {

        return r.nextInt(max);
    }

    /**
     * retorna un int aleatorio
     *
     * @return integer
     */
    public static int getInt() {

        return r.nextInt();
    }

    /**
     * Retorna un String con una nombre mas dos apellidos
     *
     * @return String
     */
    public static String getNombreCompleto() {

        return nom[r.nextInt(nom.length - 1)] + apell[r.nextInt(apell.length - 1)] + apell2[r.nextInt(apell2.length - 1)];
    }

    /**
     * Retorna un numero de telefono de 9 digitos aleatorio
     *
     * @return String
     */
    public static String getTelefono() {

        return telf[r.nextInt(telf.length - 1)];
    }

    /**
     * Retorna un string con un curso
     *
     * @return String
     */
    public static String getCursos() {

        return cursos[r.nextInt(cursos.length - 1)];
    }

    /**
     * Retorna un String con una Ciudad
     *
     * @return  String
     */
    public static String getCiudad() {

        return ciudades[r.nextInt(ciudades.length - 1)];
    }

    /**
     * Retorna un String con un nombre de color
     *
     * @return String
     */
    public static String getColor() {

        return colores[r.nextInt(colores.length - 1)];

    }

    /**
     * Retorn un numero de la NSS de 11 Digitos
     *
     * @return String
     */
    public static String getNss() {
        String n = "";

        for (int i = 0; i < 11; i++) {
            n += String.valueOf(r.nextInt(9));
        }

        return n;
    }

    /**
     * Retorna una matricula tipo [9999ABD] [AB9999CD]
     *
     * @return String
     */
    public static String getMatriculas() {

        String m = "", n = "";
        char a;
        char b;
        char c;

        n += String.valueOf(r.nextInt(9));
        n += String.valueOf(r.nextInt(9));
        n += String.valueOf(r.nextInt(9));
        n += String.valueOf(r.nextInt(9));
        a = (char) (r.nextInt(26) + 65);
        b = (char) (r.nextInt(26) + 65);
        c = (char) (r.nextInt(26) + 65);
        if (r.nextBoolean()) {
            m += a;
            m += b;
            m += n;

            a = (char) (r.nextInt(26) + 65);

            m += c;
            m += a;
            m += 'A';

            m = m.substring(0, m.length() - 1);
            return m;
        } else {
            m += a;
            m += b;
            m += c;
            m += 'A';
            n += m.substring(0, m.length() - 1);
            return n;
        }

    }

    /**
     * Retorna un un multiplo de 1000 x([123456])
     *
     * @return integer
     */
    public static int getPotencias() {

        return r.nextInt(6) * 1000;
    }

    /**
     * retorn un numero entre 0 y 20
     *
     * @return integer
     */
    public static int getPlazas() {

        return r.nextInt(20);
    }

    public static String getFunciones() {

        return funciones[r.nextInt(funciones.length - 1)];
    }

    /**
     * retorn un email valido
     *
     * @return String
     */
    public static String getEmails() {
        String n = nom[r.nextInt(nom.length - 1)].replace(' ', '.');

        if (r.nextBoolean()) {
            n += apell[r.nextInt(apell.length - 1)].replace(' ', '@') + "gmail.com";
        } else {
            n += apell2[r.nextInt(apell2.length - 1)].replace(' ', '@') + "hotmail.com";
        }
        return n;

    }

    /**
     * retorna un DNI valido
     *
     * @return String
     */
    public static String getDNI() {

        String dni = "";

        for (int i = 0; i < 8; i++) {
            dni = dni + Integer.toString(r.nextInt(9));

        }
        int num = (Integer.parseInt(dni) % 23);
        dni = dni.concat(letrasDNI.charAt(num) + "");

        return dni;
    }

    /**
     * retorna un multipo de 100 *([123456789])
     *
     * @return int
     */
    public static int getVolumenes() {
        return r.nextInt(10) * 100;
    }

    /**
     * retorna la licencia del codigo fuente
     *
     * @return String
     */

    public static String getLicencia() {
        String s = " This program is free software: you can redistribute it and/or modify \n";
        s += "it under the terms of the GNU General Public License as published by\n";
        s += "the Free Software Foundation, either version 3 of the License, or\n";
        s += "(at your option) any later version.\n";

        s += "This program is distributed in the hope that it will be useful,\n";
        s += "but WITHOUT ANY WARRANTY; without even the implied warranty of\n";
        s += "MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the\n";
        s += "GNU General Public License for more details.\n";

        s += "You should have received a copy of the GNU General Public License\n";
        s += "along with this program.  If not, see <http://www.gnu.org/licenses/>.";
        return s;
    }

}
