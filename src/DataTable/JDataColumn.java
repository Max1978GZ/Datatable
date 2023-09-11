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

import java.util.ArrayList;

/**
 * Febrero del 2014
 *
 * @author Máximo Coejo Cores mcoejo@gmail.com
 */
public class JDataColumn {

    private JDataTable Tabla;
    private String nombre;
    private String TipoDato;
    private int lengthDato;
    private ArrayList cadenas;

    /**
     * ************** constructores ****************************
     */
    /**
     * Constructor de un array vacio de String con el nombre pasado como
     * parametro
     *
     * @param nombre String
     */
    public JDataColumn(String nombre) {
        this.nombre = nombre;
        cadenas = new ArrayList<String>();
    }

    /**
     * ************** constructores ****************************
     */
    /**
     * Constructor de un array vacio de String con el nombre pasado como
     * parametro recibe como parametro el nombre de la columna, el tipo de datos
     * q contiene y la longuitud de este.
     *
     * @param nombre String
     * @param tipodato String
     * @param lengthDato Integer
     */
    public JDataColumn(String nombre, String tipodato, int lengthDato) {
        this.nombre = nombre;
        this.TipoDato = tipodato;
        this.lengthDato = lengthDato;

        switch (tipodato.toUpperCase()) {

            case "INTEGER":
            case "NUMERIC":
                cadenas = new ArrayList<Integer>();

                break;
            case "DOUBLE":
                cadenas = new ArrayList<Double>();

                break;
            case "CHAR":
            case "VARCHAR":
            default:
                cadenas = new ArrayList<String>();

                break;

        }
    }

    /**
     * Crea un JDataColumn vacio y lo relaciona con una tabla
     *
     * @param nombre String
     * @param tabla JDataTable
     */
    public JDataColumn(String nombre, JDataTable tabla) {
        this.nombre = nombre;
        cadenas = new ArrayList();

        this.Tabla = tabla;
        this.Tabla.addColumn(this);
    }

    /**
     * *************** PROPIEDADES **************************
     */
    /**
     * Retorna la longuitud maxima que pueden tener los datos del JDataColumn
     *
     * @return Integer
     */
    public int getLenghtDato() {
        return lengthDato;
    }

    /**
     * Asigna una longuitud maxima a los datos del JDataColumn
     *
     * @param lengthDato Integer
     */
    public void setLenghtDato(int lengthDato) {
        this.lengthDato = lengthDato;
    }

    /**
     * retorna la tabla a que esta relacinado el JDataTable
     *
     * @return JDataTable
     */
    public JDataTable getDataTable() {
        return Tabla;
    }

    /**
     * Asigna una columna al JDataTable y crea tantas filas como las q tenga el
     * JDataTable pendiente de verificacion .......
     *
     * @param Tabla JDataTable
     */
    public void setDataTable(JDataTable Tabla) {
        this.Tabla = Tabla;
        int num = this.Tabla.getRowsLenth() - this.cadenas.size();
        if (num > 0) {
            for (int i = 0; i < num; i++) {

                this.cadenas.add("");
            }
        } else {
            for (int i = -1; i > num; i--) {

                this.cadenas.remove(this.cadenas.size() + i);
            }
        }
    }

    /**
     * Retorna el nombre de la Columna
     *
     * @return String
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Asigna un nombre a la columna
     *
     * @param nombre String
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Retorna un ArrayList con todas las filas del JDataColumn
     *
     * @return ArrayList
     */
    public ArrayList<String> getFilas() {
        return cadenas;
    }

    /**
     * Retorna un array con todas las filas del JDataColumn
     *
     * @return String[]
     */
    public String[] getFilasToArray() {

        String s[] = new String[this.cadenas.size()];
        for (int i = 0; i < this.cadenas.size(); i++) {
            s[i] = this.cadenas.get(i).toString();

        }

        return s;
    }

    /**
     * Sobreescribe el array de filas del JDataColumn
     *
     * @param filas ArrayList
     */
    public void setFilas(ArrayList<String> filas) {
        this.cadenas = filas;
    }

    /**
     * Retorna un String con el tipo de dato que contiene la JDataColum
     *
     * @return String
     */
    public String getTipoDato() {
        return TipoDato;
    }

    /**
     * Asigna un tipo de dato a la JDataColumn
     *
     * @param TipoDato String
     */
    public void setTipoDato(String TipoDato) {
        this.TipoDato = TipoDato;
    }

    /**
     * *************** FIN PROPIEDADES *********************************
     */
    /**
     * *************** METODOS ****************************************
     */
    /**
     * Añade tantas filas como indique num
     * e introduce la cadena  contenida en valor
     * @param num integer con el numero de filas que queremos añadir
     * @param valor String con el valor a añadir en el ArrayList
     */
    public void addDatos(int num, String valor) {
        for (int i = 0; i < num; i++) {
            this.cadenas.add(valor);
        }
    }

    /**
     * Añade un valor al array de String controla la longitud del valor y lo
     * recorta si procede
     *
     * @param valor String con la cadena a añadir
     */
    public void add(String valor) {
        if (valor == null) {
            valor = "";
        }
        if (this.lengthDato > 0) {
            if (valor.length() > this.lengthDato) {
                valor = valor.substring(0, lengthDato);
            }
        }
        this.cadenas.add(valor);
    }

    /**
     * Retorna la cantidad de filas de la columna
     *
     * @return integer
     */
    public int lenth() {
        return this.cadenas.size();
    }

    /**
     * Retorna un String con el contenido del array en la posicion indicada por
     * parametro
     *
     * @param index integer
     * @return String
     */
    public String getRow(int index) {

        return this.cadenas.get(index).toString();

    }

    /**
     * Asigna un valor a la posicion del array indicada por parametro controla
     * la longitud del valor y lo recorta si procede
     *
     * @param valor String
     * @param index Integer
     */
    public void SetRow(int index, String valor) {
        if (valor == null) {
            valor = "";
        }
        if (this.lengthDato > 0) {
            if (valor.length() > this.lengthDato) {
                valor = valor.substring(0, lengthDato);
            }
        }

        this.cadenas.set(index, valor);

    }

    /**
     * Elimina la fila indicada por la posicion (index) del JDataColumn Retorna
     * el contenido de la fila eliminada
     *
     * @param index Integer
     * @return String
     */
    public String deleteRow(int index) {
        return this.cadenas.remove(index).toString();

    }

}
