Feature: Flujos Operaciones Empresa Agente
  _Feature para automatizar flujo Operaciones Empresa Agente

  @CrearEmpresa-Agente
  Scenario Outline: Crear Empresa Wappe
    Given Usuario se encuentra en la Web Wappe Agente "<login>"
    When Completa datos de login y da click en el boton ingresar "<login>"
    And Usuario selecciona boton crear empresa y ingresa datos solicitados "<caso_de_prueba>"
    Then Usuario da clic en el boton Crear y se valida empresa creada

    Examples:
      | login | caso_de_prueba |
      | 1     | 1              |