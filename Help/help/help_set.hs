<?xml version='1.0' encoding='ISO-8859-1' ?>
<!DOCTYPE helpset
  PUBLIC "-//Sun Microsystems Inc.//DTD JavaHelp HelpSet Version 2.0//EN"
         "http://java.sun.com/products/javahelp/helpset_2_0.dtd">

<helpset version="2.0">
  <!-- Título del HelpSet -->
  <title>Ayuda de la Aplicación</title>

  <!-- Ubicación del archivo de mapa -->
  <maps>
    <homeID>inicio</homeID>
    <mapref location="map_file.jhm"/>
  </maps>

  <!-- Ubicación de la tabla de contenidos -->
  <view>
    <name>TOC</name>
    <label>Tabla de Contenidos</label>
    <type>javax.help.TOCView</type>
    <data>toc.xml</data>
  </view>

  <!-- Repetir el view anterior con type javax.help.IndexView y la ubicación del índice, si lo hubiese -->


  <!-- Otras configuraciones como búsquedas, etc., pueden ser agregadas aquí -->
</helpset>