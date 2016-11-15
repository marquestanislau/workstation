<div class="escalaos form">
<?php echo $this->Form->create('Escalao'); ?>
	<fieldset>
		<legend><?php echo __('Edit Escalao'); ?></legend>
	<?php
		echo $this->Form->input('id');
		echo $this->Form->input('nome');
		echo $this->Form->input('categoria_id');
		echo $this->Form->input('clazze_id');
	?>
	</fieldset>
<?php echo $this->Form->end(__('Submit')); ?>
</div>
<div class="actions">
	<h3><?php echo __('Actions'); ?></h3>
	<ul>

		<li><?php echo $this->Form->postLink(__('Delete'), array('action' => 'delete', $this->Form->value('Escalao.id')), array('confirm' => __('Are you sure you want to delete # %s?', $this->Form->value('Escalao.id')))); ?></li>
		<li><?php echo $this->Html->link(__('List Escalaos'), array('action' => 'index')); ?></li>
		<li><?php echo $this->Html->link(__('List Categorias'), array('controller' => 'categorias', 'action' => 'index')); ?> </li>
		<li><?php echo $this->Html->link(__('New Categoria'), array('controller' => 'categorias', 'action' => 'add')); ?> </li>
		<li><?php echo $this->Html->link(__('List Rclasses'), array('controller' => 'clazzes', 'action' => 'index')); ?> </li>
		<li><?php echo $this->Html->link(__('New Rclasse'), array('controller' => 'clazzes', 'action' => 'add')); ?> </li>
	</ul>
</div>
