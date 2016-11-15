<div class="escalaos form">
<?php echo $this->Form->create('Escalao'); ?>
	<fieldset>
		<legend><?php echo __('Add Escalao'); ?></legend>
	<?php
		echo $this->Form->input('nome');
		echo $this->Form->input('categoria_id', array('empty' => '-- Selecione a categoria --'));
		echo $this->Form->input('clazze_id', array('empty' => '-- Seleccione a carreira --'));
	?>
	</fieldset>
<?php echo $this->Form->end(__('Submit')); ?>
</div>
<div class="actions">
	<h3><?php echo __('Actions'); ?></h3>
	<ul>

		<li><?php echo $this->Html->link(__('List Escalaos'), array('action' => 'index')); ?></li>
		<li><?php echo $this->Html->link(__('List Categorias'), array('controller' => 'categorias', 'action' => 'index')); ?> </li>
		<li><?php echo $this->Html->link(__('New Categoria'), array('controller' => 'categorias', 'action' => 'add')); ?> </li>
		<li><?php echo $this->Html->link(__('List Classes'), array('controller' => 'clazzes', 'action' => 'index')); ?> </li>
		<li><?php echo $this->Html->link(__('New Classes'), array('controller' => 'clazzes', 'action' => 'add')); ?> </li>
	</ul>
</div>
