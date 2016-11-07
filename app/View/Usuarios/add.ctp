<div class="mdl-cell mdl-cell--2-col"></div>
<div class="mdl-cell mdl-cell--5-col" role="form">
<?php echo $this->Form->create('Usuario', array('type' => 'file')); ?>
	<fieldset>
		<legend><?php echo __('Adicionar utilizador'); ?></legend>
		<div class="form-group">
			<?php echo $this->Form->input('nome', array('class' => 'form-control'));?>
		</div>
		<div class="form-group">
			<?php echo $this->Form->input('apelido', array('class' => 'form-control')); ?>
		</div>
		<div class="form-group">
			<?php echo $this->Form->input('email', array('class' => 'form-control')); ?>
		</div>
		<div class="form-group">
			<?php echo $this->Form->input('contacto', array('class' => 'form-control')); ?>	
		</div>
	<?php
		$hoje = date("Y-m-d");
		echo $this->Form->input('data_de_registo', array('value' => $hoje,'type' => 'hidden'), array('class' => 'btn btn-default'));
		
		echo $this->Form->input('foto_perfil', array('value' => 'upload/perfil_default.png', 'type' => 'file'));
	?>
	</fieldset>
	<hr>
<?php 
	echo $this->Form->button('Salvar', array('class'=>'mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent'));
	echo $this->Form->end();
 ?>
</div>
<div class="mdl-cell mdl-cell--3-col">
	<?php echo $this->Html->link(__('Lista de utilizadores'), array('action' => 'index'), array('class' => 'btn btn-default')); ?>
</div>
