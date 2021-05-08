package sv.edu.udb.guia12appcontentprovider;

import android.content.UriMatcher;
import android.net.Uri;
import android.provider.BaseColumns;

public class StudentsContract {
    //Tabla a consultar
    public static final String STUDENTS = "students";
    //Código para URIs de multiple registros
    public static final int ALLROWS = 1;
    //Codigo URI para un solo Rehgistro
    public static final int SINGLE_ROW = 2;
    //Autoridad del center Provider
    public final static String AUTHORITY = "sv.edu.udb.guia12appcontentprovider";
    //URI de contenido principal
    public final static Uri CONTENT_URI = Uri.parse("content://"+ AUTHORITY +"/"+ STUDENTS);
    public final static String SINGLE_MIME = "vnd.android.cursor.item/vnd." + AUTHORITY + STUDENTS;
    public final static String MULTIPLE_MIME = "vnd.android.cursor.dir/vnd." + AUTHORITY + STUDENTS;

    //Comparador de URIs de contenido
    public static final  UriMatcher uriMatcher;
    //Asignacion de URIs
    static {
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(AUTHORITY,STUDENTS, ALLROWS);
        uriMatcher.addURI(AUTHORITY, STUDENTS + "/#", SINGLE_ROW);
    }
    //Estructura de tabla
    public static class Columnas implements BaseColumns{
        private Columnas(){

        }

        public final static String NOMBRE = "nombre";
        public final static String APELLIDO = "apellido";
        public final static String CARNET = "carnet";
    }
}
