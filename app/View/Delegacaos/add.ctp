<div class="delegacaos form">
<?php echo $this->Form->create('Delegacao'); ?>
	<fieldset>
		<legend><?php echo __('Add Delegacao'); ?></legend>
	<?php
		echo $this->Form->input('nome');
	?>
	</fieldset>
<?php echo $this->Form->end(__('Submit')); ?>
</div>
<div class="actions">
	<h3><?php echo __('Actions'); ?></h3>
	<ul>

		<li><?php echo $this->Html->link(__('List Delegacaos'), array('action' => 'index')); ?></li>
	</ul>
</div>
