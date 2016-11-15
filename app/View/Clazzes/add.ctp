<div class="clazzes form">
<?php echo $this->Form->create('Clazze'); ?>
	<fieldset>
		<legend><?php echo __('Add Clazze'); ?></legend>
	<?php
		echo $this->Form->input('nome');
		echo $this->Form->input('carreira_id');
	?>
	</fieldset>
<?php echo $this->Form->end(__('Submit')); ?>
</div>
<div class="actions">
	<h3><?php echo __('Actions'); ?></h3>
	<ul>

		<li><?php echo $this->Html->link(__('List Clazzes'), array('action' => 'index')); ?></li>
		<li><?php echo $this->Html->link(__('List Carreiras'), array('controller' => 'carreiras', 'action' => 'index')); ?> </li>
		<li><?php echo $this->Html->link(__('New Carreira'), array('controller' => 'carreiras', 'action' => 'add')); ?> </li>
		<li><?php echo $this->Html->link(__('List Escalaos'), array('controller' => 'escalaos', 'action' => 'index')); ?> </li>
		<li><?php echo $this->Html->link(__('New Escalao'), array('controller' => 'escalaos', 'action' => 'add')); ?> </li>
	</ul>
</div>
