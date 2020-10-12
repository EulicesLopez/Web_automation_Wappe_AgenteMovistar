Feature: Flujos Operaciones Reportes Agente
  _Feature para automatizar flujo de reportes

  @DescargarReporteCobranzasSolicitudFM-Agente
  Scenario Outline: Descargar Reporte Cobranzas Solicitud FM
    Given Usuario se encuentra en la Web Wappe Agente "<login>"
    When Completa datos de login y da click en el boton ingresar "<login>"
    Then Usuario da clic menu reportes y elige reporte cobranzas solicitud de FM

    Examples:
      | login |
      | 1     |


  @DescargarReporteCobranzasDetalleFM-Agente
  Scenario Outline: Descargar Reporte Cobranzas Detalle FM
    Given Usuario se encuentra en la Web Wappe Agente "<login>"
    When Completa datos de login y da click en el boton ingresar "<login>"
    Then Usuario da clic menu reportes y elige reporte cobranzas detalle de FM

    Examples:
      | login |
      | 1     |


  @DescargarReporteCobranzasSolicitudFF-Agente
  Scenario Outline: Descargar Reporte Cobranzas Solicitud FF
    Given Usuario se encuentra en la Web Wappe Agente "<login>"
    When Completa datos de login y da click en el boton ingresar "<login>"
    Then Usuario da clic menu reportes y elige reporte cobranzas solicitud de FF

    Examples:
      | login |
      | 1     |



  @DescargarReporteCobranzasDetalleFF-Agente
  Scenario Outline: Descargar Reporte Cobranzas Detalle FF
    Given Usuario se encuentra en la Web Wappe Agente "<login>"
    When Completa datos de login y da click en el boton ingresar "<login>"
    Then Usuario da clic menu reportes y elige reporte cobranzas detalle de FF

    Examples:
      | login |
      | 1     |