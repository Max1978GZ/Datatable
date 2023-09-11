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

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 * Febrero del 2014
 * @author Máximo Coejo Cores mcoejo@gmail.com
 */
public class JDataTable {
    private String nombre;
    private ArrayList<JDataColumn> Columnas;
/********************* CONSTRUCTORES **********************************   */
    /**
     * Crea una JDataTable con un ArrayList que guardan las columnas 
     * @param nombreTabla String
     * @param Columnas ArrayList
     */
    public JDataTable(String nombreTabla, ArrayList<JDataColumn> Columnas) {
        this.nombre = nombreTabla;
        this.Columnas = Columnas;
     }  

    /**
     * Crea una tabla segun sea el ResultSet pasado como parametro
     * @param rs ResultSet
     * @throws SQLException por acceso a ResultSet
     */
    public JDataTable(ResultSet rs) throws SQLException{
       Columnas = new ArrayList();
       ResultSetMetaData rsMetaData = rs.getMetaData();
       int i = rsMetaData.getColumnCount();
       
       for(int a=1;a<=i;a++){
            Columnas.add(new JDataColumn( rsMetaData.getColumnLabel(a),rsMetaData.getColumnTypeName(a),rsMetaData.getPrecision(a)));       
        }
       while(rs.next()){
         for (int d=0;d<i;d++){
             Columnas.get(d).add(rs.getString(Columnas.get(d).getNombre()));
           }  
        }   
    }
   
    /**
     * Crea una tabla vacia 
     * @param nombre  String
     */
    public JDataTable(String nombre) {
        this.nombre = nombre;
        this.Columnas= new ArrayList();       
    }
/******************************************************************************/   
    /**
     * Inserta una columna en la tabla y ajusta todas las filas de todas las columnas
     * @param col JDataColumn
     */
    public void addColumn(JDataColumn col){
       
        if(this.Columnas.size()>0){
            int i =this.Columnas.get(0).lenth();
            int j =col.lenth();
            if (i-j>0){
                for(int a=0; a<i-j; a++){
                     col.add("");
                }
            }else if(i-j<0){
                for(int a=0;a<this.Columnas.size();a++){
                    this.Columnas.get(a).addDatos(j-i,"");                
                }
            }
        }
        this.Columnas.add(col);
    }
    
    
    
    /**
     * Elimina una Columna de la tabla si existe
     * @param nameColumn String
     */
    public void delColumn(String nameColumn){
        int a= this.findColumn(nameColumn);
        if (a>-1){
            this.Columnas.remove(a);            
        }     
        
    }
    /**
     * Retorna la posicicon de la primera coincidencia del nombre del JDataColumn con el parametro name
     * En caso de que no exista retorna -1
     * @param name String
     * @return int
     */
    public int findColumn(String name){
        
        for (int i =0; i <this.Columnas.size();i++){
            if(name.equalsIgnoreCase(this.Columnas.get(i).getNombre()))
                return i;
            
        }
        return -1;        
    }
     
    
    /**
     * Devuelve el numero de columnas del Array
     * @return  integer
     */
    public int getColumnLenth() {
        return this.Columnas.size();
    }
   
  /**
     * Devuelve el numero de filas de la columna
     * @return  integer
     */
    public int getRowsLenth() {
        if(this.Columnas.size()>0){
            return this.Columnas.get(0).lenth();
        }  
        
        return 0;
    }
    
    /**
     * Retorna el JDataColumn correspodiente al index pasado por parametro
     * @param index Integer
     * @return JDataColumn
     */
    public JDataColumn getColumn(int index){
        
       return this.Columnas.get(index);
        
    }
    
    
    /**
     * Retorna el nombre de la tabla
     * @return String
     */
    public String getName() {
        return nombre;
    }
    /**
     * Asigna un nuevo nommbre a la tabla
     * @param nombre String
     */
    public void setName(String nombre) {
        this.nombre = nombre;
    }
    /**
     * retona un arraylist con las columnas de la tabla 
     * @return ArrayList
     */
    public ArrayList<JDataColumn> getColumns() {
        return Columnas;
    }
    /**
     * Muestra por consola la tabla almacenada 
     */    
    public void showTabla(){
        // Imprimimos los nombres de las columnas
        for(int i=0 ; i<this.Columnas.size();i++){
           JDataColumn ca = (JDataColumn) this.Columnas.get(i);
           System.out.print("        [" +ca.getNombre()+"]      ");          
        }            
        System.out.println();
          
        for(int a=0 ; a<this.Columnas.get(0).lenth();a++){//filas
             for(int i=0 ; i<this.Columnas.size();i++){ //columnas
                    JDataColumn c = (JDataColumn) this.Columnas.get(i);
          
                    
                    System.out.print("    <"+c.getFilas().get(a) +">      ");                
             }   
           System.out.println();
        }
    }
    
    /**
     * Retorna un String con todos los datos de la tabla 
     * @return String
     */
    public String showTablaToString(){
        String s = "";
        for(int i=0 ; i<this.Columnas.size();i++){
           JDataColumn ca = (JDataColumn) this.Columnas.get(i);
          s=s.concat("   [" +ca.getNombre()+"]  ");          
        }            
        s=s.concat("\n");
         for(int a=0 ; a<this.Columnas.get(0).lenth();a++){
            for(int i=0 ; i<this.Columnas.size();i++){
       
           JDataColumn c = (JDataColumn) this.Columnas.get(i);
           s=s.concat("   <"+c.getFilas().get(a) +">  ");                
        }   
           s=s.concat("\n");
        }
        
        return s;
    }
    
     /**
     * Retorna un String con todos los datos de la tabla 
     * @return String
     */
    public String getTablaHtml(){
        String s = "<table border=\"2\">  <thead><tr>";
        
        for(int i=0 ; i<this.Columnas.size();i++){
           JDataColumn ca = (JDataColumn) this.Columnas.get(i);
          s=s.concat("   <th>" +ca.getNombre()+"</th>  ");          
        }
        s+="</tr> </thead>";
        
        
        s=s.concat("<tr>");
         for(int a=0 ; a<this.Columnas.get(0).lenth();a++){
            for(int i=0 ; i<this.Columnas.size();i++){
       
           JDataColumn c = (JDataColumn) this.Columnas.get(i);
           s=s.concat("   <td>"+c.getFilas().get(a) +"</td>  ");                
        }   
           s=s.concat("</tr>");
        }
        s+="</table>";
        return s;
    }
    
    /** retorna un ArrayList con los datos de la tabla
     * 
     * @return Arraylist
     */
    public  ArrayList<ArrayList> toArrayList(){
        ArrayList<ArrayList> tabla = new ArrayList();
        
        for(int i=0 ; i<this.Columnas.size();i++){
           JDataColumn ca = (JDataColumn) this.Columnas.get(i);
           System.out.print("        [" +ca.getNombre()+"]      ");          
        }            
     
        for(int a=0 ; a<this.Columnas.get(0).lenth();a++){//filas 
       
            ArrayList<String> col= new ArrayList<>();
            for(int i=0 ; i<this.Columnas.size();i++){
                     JDataColumn c = (JDataColumn) this.Columnas.get(i);
                     col.add(c.getFilas().get(a));                
             }   
           tabla.add(col);
           System.out.println();
        }     
        
        
        return tabla;
    }
    
    /**
     * Retorna un array de String con las etiquetas de las columnas de la tabla
     * @return String []
     */
    public String[] getLabelColumn(){
        String[] a= new String[this.Columnas.size()];
        for (int i=0;i<this.Columnas.size();i++){
            a[i]=this.Columnas.get(i).getNombre();
            
            
        }
            return a;
        
    }  
    
    /**
     * Retorna un array de String con las etiquetas mas el tipodato de casa columna de la tabla
     * @return String[]
     */
    public String[] getLabelTypeLengthColumn(){
        String[] a= new String[this.Columnas.size()];
        for (int i=0;i<this.Columnas.size();i++){
            a[i]=this.Columnas.get(i).getNombre()+"[" +this.Columnas.get(i).getTipoDato()+"](" +this.Columnas.get(i).getLenghtDato() +")";
            
            
        }
            return a;
        
    }
    
    /**
     * Retorna un DefaulTableModel con los datos de la tabla 
     * @return DefaultTableModel
     */
    
    public DefaultTableModel getDefaultTableModel(){
        DefaultTableModel m = new DefaultTableModel();
        for (JDataColumn c:this.getColumns()){
                m.addColumn(c.getNombre(), c.getFilas().toArray());
         }
        return m;
    }       
}  
    
    
    
    