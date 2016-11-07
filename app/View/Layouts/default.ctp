<?php
/**
* @link          http://cakephp.org CakePHP(tm) Project
* @package       app.View.Layouts
* @since         CakePHP(tm) v 0.10.0.1076
*/

$cakeDescription = __d('cake_dev', 'SIGERHU-UP');
?>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<?php echo $this->Html->charset(); ?>
<title>
	<?php echo $cakeDescription ?>:
	<?php echo $this->fetch('title'); ?>
</title>
<?php
echo $this->Html->meta('icon');
#Inclusao de bootstrap
echo $this->Html->css('bootstrap/bootstrap.min');
#	echo $this->Html->css('cake.generic');
echo $this->Html->css('material/material.indigo-orange.min');
	# Funciona quando possuimos uma conexao com a internet
echo $this->Html->css('https://fonts.googleapis.com/icon?family=Material+Icons');
#Modificacao de alguns aspectos (Modificacao do aspecto default)
echo $this->Html->css('custom');
	#Carrega o javascript do framwork da google mdl
echo $this->Html->script('material/material.min');
#Carrega o script de bootstrap
echo $this->Html->script('jquery-ui-1.10.3.custom.min');
echo $this->Html->script('bootstrap/bootstrap.min');

echo $this->fetch('meta');
echo $this->fetch('css');
echo $this->fetch('script');
?>
</head>
<body>
<!-- Always shows a header, even in smaller screens. -->
<div class="mdl-layout mdl-js-layout mdl-layout--fixed-drawer mdl-layout--fixed-header">
  <header class="mdl-layout__header">
    <div class="mdl-layout__header-row">
      <!-- Title -->
      <span class="mdl-layout-title">
        Sistema de gest&atilde;o de recursos humanos da UP
      </span>
     <!-- Add spacer, to align navigation to the right -->
     <div class="mdl-layout-spacer"></div>
     <!-- Navigation. We hide it in small screens. -->
      <nav class="mdl-navigation mdl-layout--large-screen-only">
        <a id="perfil_link" class="mdl-navigation__link" href="#">
          Bem vindo, Admin
          <i class="material-icons mdl-list__item-avatar">person</i>
        </a>
      </nav>
      <ul class="mdl-menu mdl-menu--bottom-left mdl-js-menu mdl-js-ripple-effect"
    for="perfil_link">
        <li class="mdl-menu__item">Perfil</li>
        <li class="mdl-menu__item mdl-menu__item--full-bleed-divider">Another Action</li>
        <li class="mdl-menu__item"><span class="glyphicon glyphicon-log-out"></span> Sair</li>
      </ul>
    </div>
  </header>
  <div class="mdl-layout__drawer">
    <span class="mdl-layout-title">
      <?php
        echo $this->Html->link(
          $this->Html->image("icon72x72.png", array("alt" => "Image not found")),
          "/",
          array('escape' => false)
        );
      ?>
      SIGERH
    </span>
    <hr/>
    <nav class="mdl-navigation">
      <a class="mdl-navigation__link" href="">Link</a>
      <a class="mdl-navigation__link" href="">Link</a>
      <a class="mdl-navigation__link" href="">Link</a>
      <a class="mdl-navigation__link" href="">Link</a>
    </nav>
    <hr>
    <nav class="mdl-navigation">
      <a class="mdl-navigation__link" href="">
        <span class="glyphicon glyphicon-log-out"></span>
        Sair
      </a>
    </nav>
</div>
<main class="mdl-layout__content">
  <div class="page-content">
    <?php echo $this->Session->flash(); ?>
    <div class="mdl-grid">      
      <!--<div class="mdl-cell mdl-cell--12-col">-->
        <?php echo $this->fetch('content'); ?>  	
      <!--</div>-->
    </div>
  </div>
</main>
<footer class="mdl-mini-footer">
<div class="mdl-mini-footer__left-section">
  <div class="mdl-logo">Title</div>
  <ul class="mdl-mini-footer__link-list">
    <li><a href="#">Help</a></li>
    <li><a href="#">Privacy & Terms</a></li>
  </ul>
</div>
</footer>
</div>
</body>
</html>
