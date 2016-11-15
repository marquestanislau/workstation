<div style="margin-bottom: 15px;" class="col-md-12 limit-down">
  <h5 class="settings-font-color">
    <span class="glyphicon glyphicon-cog settings-font-color"></span>
    Configura&ccedil;&otilde;es
  </h5>
  <small class="settings-font-color">
    Esta janela contem links que sao uteis para configuracao inicial dos principais parametros de contratacao de funcionarios e agentes do estado
  </small>
</div>
<div class="col-md-6">
  <div class="media">
  <div class="media-left media-top">
      <span style="font-size: 32px;" class="glyphicon glyphicon-briefcase media-object settings-font-color"></span>
  </div>
  <div class="media-body settings-font-color">
    <h4 class="media-heading settings-font-color">Carreiras</h4>
    <p>Adicione, consulte ou remova as carreiras do sistema</p>
    <p><?php echo $this->Html->link("<span class='glyphicon glyphicon-list'></span> Lista de carreiras", array('controller' => 'carreiras', 'action' => 'index'), array('escape' => false)); ?></p>
    <p><?php echo $this->Html->link("<span class='glyphicon glyphicon-plus-sign'></span> Adicionar carreiras", array('controller' => 'carreiras', 'action' => 'add'), array('escape' => false)); ?></p>
  </div>
</div>  
</div>
<div class="col-md-6">
  <div class="media">
  <div class="media-left media-top settings-font-color">
      <span style="font-size: 32px;" class="glyphicon glyphicon-map-marker media-object"></span>
  </div>
  <div class="media-body settings-font-color">
      <h4 class="media-heading">Delega&ccedil;&otilde;es</h4>
    <p>Adicione ou consulte as delega&ccedil;&otilde;es actualmente existentes no sistema</p>
    <p><?php echo $this->Html->link("<span class='glyphicon glyphicon-list'></span> Lista de delega&ccedil;&otilde;es", array('controller' => 'delegacaos', 'action' => 'index'), array('escape' => false)); ?></p>
    <p><?php echo $this->Html->link("<span class='glyphicon glyphicon-plus'></span> Registrar nova delega&ccedil;&atilde;o", array('controller' => 'delegacaos', 'action' => 'add'), array('escape' => false)); ?></p>
    <p><?php echo $this->Html->link("<span class='glyphicon glyphicon-trash'></span> Remover todas delega&ccedil;&otilde;es", array('controller' => 'delegacaos', 'action' => 'add'), array('escape' => false)); ?></p>
  </div>
</div>  
</div>
<div class="col-md-6">
  <div class="media settings-font-color">
  <div class="media-left media-top">
      <span style="font-size: 32px;" class="glyphicon glyphicon-log-in media-object"></span>
  </div>
  <div class="media-body settings-font-color">
    <h4 class="media-heading">Tipos de Ingresso</h4>
    <p>Adicione novos m&eacute;todos de ingresso a institui&ccedil;&atilde;o</p>
    <p><?php echo $this->Html->link("<span class='glyphicon glyphicon-list'></span> Todas formas de ingresso", array('controller' => 'tipoingressos', 'action' => 'index'), array('escape' => false)); ?></p>
    <p><?php echo $this->Html->link("<span class='glyphicon glyphicon-plus'></span> Adicionar novos metodos de ingresso", array('controller' => 'tipoingressos', 'action' => 'add'), array('escape' => false)); ?></p>
    <p><?php echo $this->Html->link("<span class='glyphicon glyphicon-trash'></span> Remover todas formas de ingresso", array('controller' => 'tipoingressos', 'action' => 'add'), array('escape' => false)); ?></p>
  </div>
</div>  
</div>
<div class="col-md-6">
  <div class="media settings-font-color">
  <div class="media-left media-top">
      <span style="font-size: 32px;" class="glyphicon glyphicon-asterisk media-object"></span>
  </div>
  <div class="media-body settings-font-color">
    <h4 class="media-heading">Vagas</h4>
    <p>Adicione vagas para as carreiras no ambito de abertura de concurso a vagas</p>
    <p><?php echo $this->Html->link("<span class='glyphicon glyphicon-list'></span> Todas vagas", array('controller' => 'vagas', 'action' => 'index'), array('escape' => false)); ?></p>
    <p><?php echo $this->Html->link("<span class='glyphicon glyphicon-plus-sign'></span> Adicionar vagas a carreiras", array('controller' => 'vagas', 'action' => 'add') , array('escape' => false)); ?></p>
    <p><?php echo $this->Html->link("<span class='glyphicon glyphicon-trash'></span> Remover todas as vagas a carreiras", array('controller' => 'vagas', 'action' => 'add'), array('escape' => false)); ?></p>
  </div>
</div>  
</div>
<div class="col-md-6">
  <div class="media settings-font-color">
  <div class="media-left media-top">
      <span style="font-size: 32px;" class="media-object glyphicon glyphicon-list-alt"></span>
  </div>
  <div class="media-body settings-font-color">
    <h4 class="media-heading">Categorias para carreiras</h4>
    <p>Adicione, consulte ou remova as categorias de cada carreira</p>
    <p><?php echo $this->Html->link("<span class='glyphicon glyphicon-list'></span> Listas de categorias", array('controller' => 'categorias', 'action' => 'index'), array('escape' => false)); ?></p>
    <p><?php echo $this->Html->link("<span class='glyphicon glyphicon-plus'></span> Adicionar nova categoria", array('controller' => 'categorias', 'action' => 'add'), array('escape' => false)); ?></p>
     <p><?php echo $this->Html->link("<span class='glyphicon glyphicon-trash'></span> Remover todas categorias", array('controller' => 'categorias', 'action' => 'add'), array('escape' => false)); ?></p>
  </div>
</div>  
</div>
<div class="col-md-6">
  <div class="media settings-font-color">
  <div class="media-left media-top">
      <span style="font-size: 32px;" class="media-object glyphicon glyphicon-scale"></span>
  </div>
  <div class="media-body settings-font-color">
    <h4 class="media-heading">Classes</h4>
    <p>Adicione, consulte ou remova as classes para carreiras</p>
    <p><?php echo $this->Html->link("<span class='glyphicon glyphicon-list'></span> Todas classes", array('controller' => 'clazzes', 'action' => 'index'), array('escape' => false)); ?></p>
    <p><?php echo $this->Html->link("<span class='glyphicon glyphicon-plus'></span> Novas classes", array('controller' => 'clazzes', 'action' => 'add'), array('escape' => false)); ?></p>
  </div>
</div>  
</div>
<div class="col-md-6">
  <div class="media settings-font-color">
  <div class="media-left media-top">
      <span style="font-size: 32px;" class="media-object glyphicon glyphicon-scale"></span>
  </div>
  <div class="media-body settings-font-color">
    <h4 class="media-heading">Sectores</h4>
    <p>Adicione, consulte ou remova os sectores para delega&ccedil;&otilde;es</p>
    <p><?php echo $this->Html->link("<span class='glyphicon glyphicon-plus'></span> Novos sectores", array('controller' => 'sectores', 'action' => 'add'), array('escape' => false)); ?></p>
    <p><?php echo $this->Html->link("<span class='glyphicon glyphicon-list'></span> Todos sectores", array('controller' => 'sectores', 'action' => 'index'), array('escape' => false)); ?></p>
  </div>
</div>  
</div>
<div class="col-md-6">
  <div class="media settings-font-color">
  <div class="media-left media-top">
      <span style="font-size: 32px;" class="media-object glyphicon glyphicon-file"></span>
  </div>
  <div class="media-body settings-font-color">
    <h4 class="media-heading">Escal&otilde;es</h4>
    <p>Adicione, consulte ou remova os escal&otilde;es para categorias e classes</p>
    <p><?php echo $this->Html->link("<span class='glyphicon glyphicon-plus'></span> Novos escal&otilde;es", array('controller' => 'escalaos', 'action' => 'add'), array('escape' => false)); ?></p>
    <p><?php echo $this->Html->link("<span class='glyphicon glyphicon-list'></span> Todos escal&otilde;es", array('controller' => 'escalaos', 'action' => 'index'), array('escape' => false)); ?></p>
    <p><?php echo $this->Html->link("<span class='glyphicon glyphicon-trash'></span> Remover todos escal&otilde;es", array('controller' => 'escalaos', 'action' => 'index'), array('escape' => false)); ?></p>
  </div>
</div>  
</div>
<div class="col-md-6">
  <div class="media settings-font-color">
  <div class="media-left media-top">
      <span style="font-size: 32px;" class="media-object glyphicon glyphicon-folder-open"></span>
  </div>
  <div class="media-body settings-font-color">
    <h4 class="media-heading">Concursos</h4>
    <p>Adicione, consulte ou remova os concursos para recrutamento de novos funcion&aacute;rios</p>
    <p><?php echo $this->Html->link("<span class='glyphicon glyphicon-plus'></span> Novo concurso", array('controller' => 'concursos', 'action' => 'add'), array('escape' => false)); ?></p>
    <p><?php echo $this->Html->link("<span class='glyphicon glyphicon-list'></span> Concursos anteriores", array('controller' => 'concursos', 'action' => 'index'), array('escape' => false)); ?></p>
    <p><?php echo $this->Html->link("<span class='glyphicon glyphicon-trash'></span> Remover todos concursos", array('controller' => 'concursos', 'action' => 'index'), array('escape' => false)); ?></p>
  </div>
</div>  
</div>
