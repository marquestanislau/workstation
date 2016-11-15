<div class="sectores form">
<?php echo $this->Form->create('Sectore'); ?>
	<fieldset>
		<legend><?php echo __('Add Sectore'); ?></legend>
	<?php
		echo $this->Form->input('designacao');
		echo $this->Form->input('delegacao_id', array('empty' => '** Escolha a delegacao **'));
	?>
	</fieldset>
<?php echo $this->Form->end(__('Submit')); ?>
</div>
<div class="actions">
	<h3><?php echo __('Actions'); ?></h3>
	<ul>

		<li><?php echo $this->Html->link(__('List Sectores'), array('action' => 'index')); ?></li>
		<li><?php echo $this->Html->link(__('List Delegacaos'), array('controller' => 'delegacaos', 'action' => 'index')); ?> </li>
		<li><?php echo $this->Html->link(__('New Delegacao'), array('controller' => 'delegacaos', 'action' => 'add')); ?> </li>
	</ul>
</div>
