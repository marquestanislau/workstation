<div class="col-md-5">
<?php echo $this->Form->create('Carreira'); ?>
	<fieldset>
		<legend class="settings-font-color"><span class="glyphicon glyphicon-briefcase" style="font-size: 24px;"></span> <?php echo __('Adicionar Carreiras ao banco de dados'); ?></legend>
		<div class="form-group">
	<?php
		echo $this->Form->input('nome', array('class' => 'form-control', 'label' => 'Designa&ccedil;&atilde;o da carreira'));
	?>
	</div>
	</fieldset>
	<button class="btn btn-default"><span class="glyphicon glyphicon-ok"></span> Submeter</button>
<?php echo $this->Form->end(); ?>
</div>
<div class="col-md-4">
<div class="list-group">
  <a href="#" class="list-group-item active">
    <h3><?php echo __('Actions'); ?></h3>
  </a>
  <?php echo $this->Html->link("<span class='glyphicon glyphicon-list'></span> Todas carreiras", array('action' => 'index'), array('class' => 'list-group-item', 'escape' => false)); ?>
  <?php echo $this->Html->link("<span class='glyphicon glyphicon-cog'></span> Configuracoes", array('controller' => 'pages', 'action' => 'configuracao'), array('class' => 'list-group-item', 'escape' => false)); ?>
</div>
	
</div>
